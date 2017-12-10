/**
 * Created by James on 10/12/2017.
 */

// Ensures that the drop down is populated with questionnaires as soon as the page loads.
$(document).ready(function() {
    var template = $(".questionnaire-template").clone();
    $(template).removeClass('hide');

    // Get all questionnaires
    $.ajax({
        url: "/api/questionnaire/allQuestionnaires/get",
        type: "GET",
        dataType: "json"
    }).done(function (data) {

        // Iterates each questionnaire object and appends a new option to the drop down with value set as id
        data.forEach(function (questionnaire) {
            var this_template = template;

            // Add id, edit button link and title
            $(this_template).attr('id', questionnaire.questionnaireId);
            $(this_template).find('.edit-btn').attr('href', '/api/interface?q=' + questionnaire.questionnaireId);
            $(this_template).find('.questionnaire-text').html(questionnaire.questionnaireTitle);

            $("#questions-here").append($(this_template).clone());

        });
    })

    // When delete button clicked, delete questionnaire from database
    $(document.body).on('click', '.delete-option', function () {
        var theId = $(this).closest('li').attr('id');

        $.ajax({
            type: "POST",
            url: "/api/questionnaire/delete",
            dataType: 'text',
            data: {id: theId},
            success: function (data) {
                $('#'+theId).remove();
            }
        });
    });


});
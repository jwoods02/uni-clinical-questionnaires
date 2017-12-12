/**
 * Created by James on 10/12/2017.
 */

// Get question template
var template = $(".question-list-item-template").clone();
$(template).removeClass('hide');

// Get url get parameters
var urlParams = new URLSearchParams(window.location.search);

// If url parameters exist
if(urlParams.has('q')) {
    var questionnaireId = urlParams.get('q');

    $('#questionnaire-submit-form').attr('data-questionnaire-id', questionnaireId);

    // Get questionnaire title
    $.ajax({
        type: "GET",
        url: "/api/questionnaire/get?id="+questionnaireId,
        dataType: "json",
        success: function (data) {
            $('#questionnaire-title').val(data.questionnaireTitle);
        }
    });

    // Get questions in questionnaire
    $.ajax({
        type: "GET",
        url: "/api/questionnaire/questions/"+questionnaireId,
        dataType: "json",
        success: function (data) {

            $.each(data,function (index, question) {

                var thisTemplate = template.clone();

                $(thisTemplate).find('.question-list-text').html(question.questionDescription);
                $(thisTemplate).attr('id', question.questionId);

                $('#sortable2').append(thisTemplate);

            });


        }
    });


}
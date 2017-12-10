/**
 * Created by James on 10/12/2017.
 */

$('#submit_questionnaire').click(function () {

    // Get questionnaire title
    var questionnaireName = $('#questionnaire-title').val();

    var questionIdList = [];

    // Get questionnaire's question ID's
    $('#sortable2').find('li').each(function () {
        var questionId = $(this).attr('id');
        questionIdList.push(questionId);
    });

    // If questionnaire exists
    if($('#questionnaire-submit-form').attr("data-questionnaire-id")) {
        var questionnaireId = $('#questionnaire-submit-form').attr("data-questionnaire-id");

        // Submits the edited questionnaire form
        var questionnaireFormData = {
            'questionnaireId': questionnaireId,
            'questionnaireTitle': questionnaireName,
            'questionIdList': JSON.stringify(questionIdList)
        };
        $.ajax({
            type: "PUT",
            url: "/api/questionnaire",
            dataType: "json",
            data: questionnaireFormData,
            success: function (data) {
                console.log("Questionnaire update success");
            }
        });

    // If questionnaire is new
    } else {

        // Submits the new questionnaire form
        var questionnaireFormData = {
            'questionnaireTitle': questionnaireName,
            'questionIdList': JSON.stringify(questionIdList)
        };
        $.ajax({
            type: "POST",
            url: "/api/questionnaire",
            dataType: "json",
            data: questionnaireFormData,
            success: function (data) {
                console.log("Questionnaire creation success");

//                    TODO:
//                    Make this redirect to edit page
            }
        });

    }

});
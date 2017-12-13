/**
 * Created by James on 10/12/2017.
 */

// When modal is hidden
$( document ).ready(function() {
    $('#exampleModal').on('hidden.bs.modal', function () {
        // Empty create_question form
        $('#questionDescription').val('');
        $('#selectType').val('');
        onTypeChange();
    });
});

// Clone question template
var template = $(".question-list-item-template").clone();
$(template).removeClass('hide');

// Set up sortable variables
var sort1 = document.getElementById('sortable');
var sort2 = document.getElementById('sortable2');

// Set up sortable for element list
var sortable1 = Sortable.create(sort1, {
    group: {
        name: 'sort1',
        pull: 'clone',
        put: false
    },
    sort: false,
    onEnd: function(evt) {

        if ( $( evt.item ).hasClass( "multiple-choice" ) ) {

            $(evt.item).replaceWith( template.clone() );

        } else if ( $( evt.item ).hasClass( "radio-button" ) ) {

            $(evt.item).replaceWith( template.clone() );

        } else if ( $( evt.item ).hasClass( "single-line" ) ) {

            $(evt.item).replaceWith( template.clone() );

        } else if ( $( evt.item ).hasClass( "multi-line" ) ) {

            $(evt.item).replaceWith( template.clone() );

        }

    }
});

// Options for different element types (not currently used)
function newOption(type) {
    switch(type) {
        case 0:
            return '<p class="card-body"> New multiple choice question </p>' +
                '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Edit</button> ' +
                '<button class="btn btn-danger delete-option">Delete</button>';
            break;

        case 1:
            return '<p class="card-body"> New radio button question </p>' +
                '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Edit</button> ' +
                '<button class="btn btn-danger delete-option">Delete</button>';
            break;

        case 2:
            return '<p class="card-body"> New single line question </p>' +
                '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Edit</button> ' +
                '<button class="btn btn-danger delete-option">Delete</button>';
            break;

        case 3:
            return '<p class="card-body"> New multi line question </p>' +
                '<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal"> Edit</button> ' +
                '<button class="btn btn-danger delete-option">Delete</button>';
            break;

        default:
            return '<p class="card-title"> New unknown question </p>'
    }
}

// Set up sortable for question list
var sortable2 = Sortable.create(sort2, {
    group: {
        name: 'sort2',
        pull: false,
        put: 'sort1'
    },
    animation: 125
});



// When edit button clicked
$(document.body).on('click', '.question-edit-button', function () {
    // Save the question li that is being edited
    window.questionListItem = $(this).closest('li');
    $('#exampleModal').modal();
    var id = $(window.questionListItem).attr('id');

    // The following is only run if a question exists/has already been created, if not an empty form is loaded
    if (id !== null) {

        // Ajax request to get the question and display the description on the form
        $.ajax({
            type: "GET",
            url: "/api/question/"+id,
            dataType: "json",
            success: function (data) {
                // Set question description and type then load correct type template
                $('#questionDescription').val(data.questionDescription);
                $('#selectType').val(data.questionType);
                onTypeChange();

                // Ajax request to retrieve all the related options and display them in the form
                $.ajax({
                    type: "GET",
                    url: "/api/options/"+id,
                    dataType: 'json',
                    success: function (optionData) {
                        // If type is multiple choice/checkbox then load the options
                        if ((data.questionType === 1)|| (data.questionType === 4)) {

                            // Adds the correct number of option templates to the page
                            for (i=1; i < optionData.length; i++) {
                                if (data.questionType === 1) {
                                    addRadioOption()
                                } else if (data.questionType === 4) {
                                    addCheckboxOption()
                                }
                            }

                            // Retrieves each template element in the list of options
                            var ancestor = document.getElementById('listWithHandle'),
                                descendants = ancestor.getElementsByClassName('description');


                            // Sets each element's option description from the json objects
                            var i = 0;
                            optionData.forEach(function (option) {
                                var currentElement = descendants[i];
                                currentElement.value = option.optionDescription;
                                i++;
                            })
                        }
                    }
                });
            }
        });
    }
});


// When question has been saved
function updateQuestionName(id) {

    $.ajax({
        type: "GET",
        url: "/api/question/name/"+id,
        dataType: 'text',
        success: function (data) {

            // Set question li name to saved question name, then empty the variable
            $(questionListItem).find('.question-list-text').html(data);
            questionListItem = null;

        }
    });

    $('#exampleModal').modal('hide');


}

// When delete button has been pressed
$(document.body).on('click', '.delete-option', function () {
    var id = $(this).closest('li').attr('id');

    $.ajax({
        type: "DELETE",
        url: "/api/question/"+id,
        dataType: 'text',
        success: function () {
        }
    });

    $(this).closest('li').remove();

});
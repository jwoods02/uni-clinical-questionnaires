/* 
SQL QUERIES
 */
 
USE `y2_clinical_9`;

DELIMITER ;

/* 
Find our who created each questionnaire, and when
*/

SELECT questionnaire.questionnaire_title, concat(admin.first_name, " ", admin.last_name) AS NAME, questionnaire.date_created
FROM questionnaire
INNER JOIN admin
ON questionnaire.admin_id = admin.admin_id
ORDER BY admin.admin_id, questionnaire.date_created ;

/* 
Get number of each question type in each questionnaire
*/

SELECT questionnaire.questionnaire_title, question.question_type, COUNT(*)
FROM questionnaire, question
WHERE questionnaire.questionnaire_id = question.questionnaire_id
GROUP BY questionnaire.questionnaire_id, question.question_type;

/* 
Get list of questions in each questionnaire
*/

SELECT questionnaire.questionnaire_id, COUNT(*)
FROM questionnaire
LEFT JOIN question # Left join done so that questionniare is on list, even if it has zero questions
ON questionnaire.questionnaire_id = question.questionnaire_id
GROUP BY questionnaire.questionnaire_id ;


/* 
Get list of number of questionnaires that are empty
*/

SELECT questionnaire.questionnaire_id, 
(CASE
	WHEN COUNT(question.questionnaire_id) < 1 THEN "Empty"
END)
FROM questionnaire
LEFT JOIN question
ON questionnaire.questionnaire_id = question.questionnaire_id
GROUP BY questionnaire.questionnaire_id ;

/* 


PROCEDURAL SQL QUERIES


 */
 

/* 
Function to find if questionnaire is empty
*/

 # When given the primary eky for a questionnaire, determines if it contains questions and returns true or false.
DROP FUNCTION IF EXISTS IsQuestionnaireEmpty;
DELIMITER //
CREATE FUNCTION IsQuestionnaireEmpty(questionnaireId INT(4)) RETURNS VARCHAR(10)
	DETERMINISTIC
	 BEGIN
          
     DECLARE number_of_questions INT(10);
          
     SET number_of_questions = (
	 SELECT COUNT(*)
	 FROM question
	 WHERE question.questionnaire_id = questionnaireId
     GROUP BY question.questionnaire_id
     );
     
     IF number_of_questions < 1 OR NULL THEN
		RETURN "TRUE";
	 ELSE
		RETURN "FALSE";
     END IF;
     
	 END //
DELIMITER ;

# Test for function.
SELECT IsQuestionnaireEmpty(1);

/* 
Stored procedure to get all questions in a questionnaire

*/

DROP PROCEDURE IF EXISTS GetQuestionsInQuestionnaire;
DELIMITER //
CREATE PROCEDURE GetQuestionsInQuestionnaire(IN theQuestionnaire INT(10))
BEGIN
  SELECT question.question_id, question.question_description
  FROM question
  WHERE questionnaire_id = theQuestionnaire
  ORDER BY question.question_id ;
END //
DELIMITER ;

CALL GetQuestionsInQuestionnaire(1);

/* 
Trigger to null questionnaire admin_id before deleting admin
*/
 
DROP TRIGGER IF EXISTS admin_BEFORE_DELETE;
DELIMITER //
CREATE TRIGGER admin_BEFORE_DELETE BEFORE
DELETE ON admin
FOR EACH ROW
BEGIN
UPDATE questionnaire SET admin_id = replace(admin_id, OLD.admin_id, null);
END//
DELIMITER ;
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
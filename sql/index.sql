CREATE INDEX `fk_question_questionnaire1_idx` ON question (`questionnaire_id`);

CREATE INDEX `AdminID_idx` ON questionnaire (`admin_id`);

CREATE INDEX `fk_options_question1_idx` ON options (`question_id`);
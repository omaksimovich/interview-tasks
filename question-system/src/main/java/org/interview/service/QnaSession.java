package org.interview.service;

interface QnaSession {
    void addQuestion(String parentQuestion, boolean answer, String question);

    void removeQuestion(String question);

    String startSession();

    String answer(String question, boolean positive);
}

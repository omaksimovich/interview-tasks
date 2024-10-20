package org.interview.service;

public class QnaSessionImpl implements QnaSession {
    public QnaSessionImpl(String firstQuestion) {
        // TODO:
    }

    @Override
    public void addQuestion(String parentQuestion, boolean answer, String question) {
    }

    @Override
    public void removeQuestion(String question) {
    }

    /*
      we should return the any question
     */
    @Override
    public String startSession() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public String answer(String question, boolean answer) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

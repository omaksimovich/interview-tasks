package org.interview.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QnaSessionImplTest {
    @Test
    public void testQnaAnswers() {
        QnaSession session = buildQnaSession();

        String q1 = session.startSession();
        assertEquals("Ready?", q1);
        String q2 = session.answer("Ready?", false);
        assertEquals("Need more time?", q2);
        String q3 = session.answer("Need more time?", false);
        assertEquals("Start over", q3);
        assertEquals("Finished", session.answer("Start over", false));
        assertEquals("Finished", session.answer("Start over", true));

        String q4 = session.answer("Need more time?", true);
        assertEquals("Come back later", q4);
        assertEquals("Finished", session.answer("Come back later", false));
        assertEquals("Finished", session.answer("Come back later", true));

        String q5 = session.answer("Ready?", true);
        assertEquals("Weather good for ducks?", q5);
        String q6 = session.answer("Weather good for ducks?", true);
        assertEquals("Got a duck?", q6);
        String q7 = session.answer("Got a duck?", true);
        assertEquals("Take it out for a walk", q7);
        assertEquals("Finished", session.answer("Take it out for a walk", false));
        assertEquals("Finished", session.answer("Take it out for a walk", true));

        String q8 = session.answer("Got a duck?", false);
        assertEquals("Is it raining?", q8);
        String q9 = session.answer("Is it raining?", true);
        assertEquals("Take an umbrella", q9);
        assertEquals("Finished", session.answer("Take an umbrella", false));
        assertEquals("Finished", session.answer("Take an umbrella", true));

        String q10 = session.answer("Is it raining?", false);
        assertEquals("Is it snowing?", q10);
        String q11 = session.answer("Is it snowing?", false);
        assertEquals("Wear a hat", q11);
        assertEquals("Finished", session.answer("Wear a hat", false));
        assertEquals("Finished", session.answer("Wear a hat", true));
        assertEquals("Finished", session.answer("Is it snowing?", true));

        String q12 = session.answer("Weather good for ducks?", false);
        assertEquals("Lovely sunshine?", q12);
        String q13 = session.answer("Lovely sunshine?", true);
        assertEquals("Perfect", q13);
        assertEquals("Finished", session.answer("Perfect", false));
        assertEquals("Finished", session.answer("Perfect", true));
        assertEquals("Finished", session.answer("Lovely sunshine?", false));
    }

    @Test
    public void testRemoveQuestion() {
        QnaSession session = buildQnaSession();
        session.removeQuestion("Got a duck?");

        String q1 = session.answer("Weather good for ducks?", false);
        assertEquals("Lovely sunshine?", q1);
        String q2 = session.answer("Weather good for ducks?", true);

        assertEquals("Finished", q2);
    }

    @Test
    public void testLoopyStructure() {
        QnaSession session = buildQnaSession();
        session.addQuestion("Need more time?", false, "Got a duck?");

        String q1 = session.answer("Need more time?", false);

        assertEquals("Got a duck?", q1);
        String q8 = session.answer("Got a duck?", false);

        assertEquals("Is it raining?", q8);
        String q9 = session.answer("Is it raining?", true);
        assertEquals("Take an umbrella", q9);
        assertEquals("Finished", session.answer("Take an umbrella", false));
        assertEquals("Finished", session.answer("Take an umbrella", true));

        String q6 = session.answer("Weather good for ducks?", true);
        assertEquals("Got a duck?", q6);
        String q7 = session.answer("Got a duck?", true);
        assertEquals("Take it out for a walk", q7);
        assertEquals("Finished", session.answer("Take it out for a walk", false));
        assertEquals("Finished", session.answer("Take it out for a walk", true));
    }

    private QnaSession buildQnaSession() {
        QnaSession session = new QnaSessionImpl("Ready?");
        session.addQuestion("Ready?", true, "Weather good for ducks?");
        session.addQuestion("Ready?", false, "Need more time?");
        session.addQuestion("Need more time?", true, "Come back later");
        session.addQuestion("Need more time?", false, "Start over");
        session.addQuestion("Weather good for ducks?", true, "Got a duck?");
        session.addQuestion("Weather good for ducks?", false, "Lovely sunshine?");
        session.addQuestion("Got a duck?", true, "Take it out for a walk");
        session.addQuestion("Got a duck?", false, "Is it raining?");
        session.addQuestion("Is it raining?", true, "Take an umbrella");
        session.addQuestion("Is it raining?", false, "Is it snowing?");
        session.addQuestion("Is it snowing?", false, "Wear a hat");
        session.addQuestion("Lovely sunshine?", true, "Perfect");

        return session;
    }

}

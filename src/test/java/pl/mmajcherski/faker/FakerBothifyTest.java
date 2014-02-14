package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerBothifyTest {

    @Test
    public void shouldReplaceHashesWithWithDigitsAndQuestionMarksWithLetters() {
        // given
        String text = "abc??##?";

        // when
        String textifiedText = Faker.bothify(text);

        // then
        assertThat(textifiedText).matches("abc[a-z][a-z][0-9][0-9][a-z]");
    }

}

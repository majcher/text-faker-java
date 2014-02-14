package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerTextifyTest {

    @Test
    public void shouldReplaceQuestionMarkWithLetter() {
        // given
        String text = "abc???";

        // when
        String textified = Faker.textify(text);

        // then
        assertThat(textified).matches("abc[a-z][a-z][a-z]");
    }

    @Test
    public void shouldReplaceQuestionMarkWithRandomLetter() {
        // given
        String text = "test-?????";

        // when
        String textifiedText1 = Faker.textify(text);
        String textifiedText2 = Faker.textify(text);

        // then
        assertThat(textifiedText1).isNotEqualTo(textifiedText2);
    }

    @Test
    public void shouldReplaceQuestionMarkWithDifferentRandomLetters() {
        // given
        String text = "?????";

        // when
        String textified = Faker.textify(text);

        // then
        String fc = textified.substring(0, 1);
        assertThat(textified).isNotEqualTo(fc + fc + fc + fc + fc);
    }

}

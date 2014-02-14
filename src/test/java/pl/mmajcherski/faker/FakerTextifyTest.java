package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerTextifyTest {

    @Test
    public void shouldReplaceHashWithDigit() {
        // given
        String text = "abc???";

        // when
        String textifiedText = Faker.textify(text);

        // then
        assertThat(textifiedText).matches("abc[a-z][a-z][a-z]");
    }

    @Test
    public void shouldReplaceHashWithRandomDigit() {
        // given
        String text = "test-?????";

        // when
        String textifiedText1 = Faker.textify(text);
        String textifiedText2 = Faker.textify(text);

        // then
        assertThat(textifiedText1).isNotEqualTo(textifiedText2);
    }

    @Test
    public void shouldReplaceHashWithDifferentRandomDigits() {
        // given
        String text = "?????";

        // when
        String textifiedText1 = Faker.textify(text);

        // then
        String fc = textifiedText1.substring(0, 1);
        assertThat(textifiedText1).isNotEqualTo(fc + fc + fc + fc + fc);
    }

}

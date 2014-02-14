package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerNumerifyTest {

    @Test
    public void shouldReplaceHashWithDigit() {
        // given
        String text = "abc###";

        // when
        String numerifiedText = Faker.numerify(text);

        // then
        assertThat(numerifiedText).matches("abc[0-9][0-9][0-9]");
    }

    @Test
    public void shouldReplaceHashWithRandomDigit() {
        // given
        String text = "test-#####";

        // when
        String numerifiedText1 = Faker.numerify(text);
        String numerifiedText2 = Faker.numerify(text);

        // then
        assertThat(numerifiedText1).isNotEqualTo(numerifiedText2);
    }

    @Test
    public void shouldReplaceHashWithDifferentRandomDigits() {
        // given
        String text = "#####";

        // when
        String numerifiedText1 = Faker.numerify(text);

        // then
        String fc = numerifiedText1.substring(0, 1);
        assertThat(numerifiedText1).isNotEqualTo(fc + fc + fc + fc + fc);
    }

}

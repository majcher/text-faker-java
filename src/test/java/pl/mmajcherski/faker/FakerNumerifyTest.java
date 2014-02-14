package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerNumerifyTest {

    @Test
    public void shouldReplaceHashWithDigit() {
        // given
        String text = "abc###";

        // when
        String numerified = Faker.numerify(text);

        // then
        assertThat(numerified).matches("abc[0-9][0-9][0-9]");
    }

    @Test
    public void shouldReplaceHashWithRandomDigit() {
        // given
        String text = "test-#####";

        // when
        String numerified1 = Faker.numerify(text);
        String numerified2 = Faker.numerify(text);

        // then
        assertThat(numerified1).isNotEqualTo(numerified2);
    }

    @Test
    public void shouldReplaceHashWithDifferentRandomDigits() {
        // given
        String text = "#####";

        // when
        String numerified = Faker.numerify(text);

        // then
        String fc = numerified.substring(0, 1);
        assertThat(numerified).isNotEqualTo(fc + fc + fc + fc + fc);
    }

}

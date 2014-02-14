package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class FakerNegativeTest {

    @Test(expectedExceptions = NullPointerException.class)
    public void shouldThrowNpeForNullInput() {
        Faker.bothify(null);
    }

    @Test
    public void shouldHandleEmptyString() {
        // given
        String text = "";

        // when
        String bothified = Faker.bothify(text);

        // then
        assertThat(bothified).isEqualTo("");
    }

    @Test
    public void shouldNotFakeAnyOtherSpecialCharactersThanDigitAndLetterMarkers() {
        // given
        String text = "!@$%^&*()-=+;'[],./;'\\`~";

        // when
        String bothified = Faker.bothify(text);

        // then
        assertThat(bothified).isEqualTo(text);
    }

}

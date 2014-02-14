package pl.mmajcherski.faker;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomCharacterGeneratorTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldGenerateTheSameCharacterWhenMinMAxRangeIsEq1() {
        // given
        RandomCharacterGenerator sut = new RandomCharacterGenerator('x', 'x');

        // when
        String generated = sut.generate();

        // then
        assertThat(generated).isEqualTo("x");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionWhenMaxCharacterIsGreaterThanMin() {
        // given
        RandomCharacterGenerator sut = new RandomCharacterGenerator('2', '1');

        // when
        sut.generate();
    }

}

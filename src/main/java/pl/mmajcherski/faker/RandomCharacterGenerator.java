package pl.mmajcherski.faker;

import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;

class RandomCharacterGenerator implements TextGenerator {

    private final Random random = new Random();

    private final char min;
    private final char max;

    public RandomCharacterGenerator(char min, char max) {
        this.min = min;
        this.max = max;
    }

    @Override
    public String generate() {
        int firstCharInt = (int) min;
        int lastCharInt = (int) max;
        checkArgument(max >= min);

        int range = lastCharInt - firstCharInt;
        char randomChar = (char) (firstCharInt + random.nextInt(range));
        return String.valueOf(randomChar);
    }

}

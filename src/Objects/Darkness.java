package Objects;

import Enums.Gender;
import Exceptions.FearException;

public class Darkness extends LivingEntity {
    public Darkness(String name) throws FearException {
        super(name, Gender.NEUTER);
    }

    @Override
    protected void getEnding(Gender gender) {
        ending = "о ";
    }
}

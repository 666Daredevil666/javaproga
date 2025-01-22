package Objects;

import Enums.Gender;
import Exceptions.FearException;

public class Waves extends LivingEntity {
    public Waves(String name) throws FearException {
        super(name, Gender.NEUTER);
    }

    @Override
    protected void getEnding(Gender gender) {
        // Пусть для "бесполых" объектов будет окончание "о":
        ending = "о ";
    }
}

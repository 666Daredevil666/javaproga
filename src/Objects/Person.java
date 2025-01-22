package Objects;

import Enums.Gender;

public class Person extends LivingEntity {

    public Person(String name, Gender gender) {
        super(name, gender);
    }

    @Override
    protected void getEnding(Gender gender) {
        switch (gender) {
            case FEMALE -> ending = "a ";
            case NEUTER -> ending = "о ";
            default -> ending = " ";
        }
    }
}

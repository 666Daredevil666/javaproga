package Objects;

import Enums.Gender;
import Exceptions.FearException;

public class Goose extends LivingEntity {
    private boolean isOld; // старая/ый гусь?

    public Goose(String name, Gender gender, boolean isOld) throws FearException {
        super(name, gender);
        this.isOld = isOld;
        // Допустим, если гусь старый и имя "Акка", проверяем не вызываем ли выброс исключения
        if (isOld && "Акка".equalsIgnoreCase(name)) {
            // Просто пример: если вы посчитаете, что "старая Акка" должна бросать исключение — можете убрать
            if (Math.random() < 0.05) {
                throw new FearException("Старая " + name + " слишком напугана!");
            }
        }
    }

    @Override
    protected void getEnding(Gender gender) {
        // Пример как в предыдущем коде:
        switch (gender) {
            case FEMALE -> ending = "a ";
            case NEUTER -> ending = "о ";
            default -> ending = " ";
        }
    }
}

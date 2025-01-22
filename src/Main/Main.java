package Main;

import Enums.Action;
import Enums.Gender;
import Enums.Place;
import Exceptions.FearException;
import Exceptions.SomethingBlackException;
import Objects.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Создаём объекты
            // 1) несколько гусей в ArrayList (выполняем требование "массив или ArrayList однотипных объектов")
            List<Goose> geese = new ArrayList<>();
            // Старый гусь (Акка) и несколько обычных
            Goose akka = new Goose("Акка", Gender.FEMALE, true);
            geese.add(akka);
            geese.add(new Goose("Гусь №1", Gender.MALE, false));
            geese.add(new Goose("Гусь №2", Gender.MALE, false));

            // 2) Нильс
            Person nils = new Person("Нильс", Gender.MALE);

            // 3) Волны и Темнота (Thing'и, либо отдельные классы)
            Waves waves = new Waves("волны");
            Darkness darkness = new Darkness("тьма");

            // 4) Пример использования record
            BlacknessRecord blackness = new BlacknessRecord(1);

            System.out.println("\n===== Начинается сценарий =====\n");

            // «Объятые страхом перед наступающей ночью, гуси летели сами не зная куда.»
            for (Goose goose : geese) {
                goose.doSomething(Action.FEEL_FEAR);
                goose.setPlace(Place.NIGHT);
                goose.doSomething(Action.FLY);
                goose.getMessage(".");
            }

            System.out.println();

            // «Тьма быстро сгущалась.»
            // Темнота — просто Thing, у него нет doSomething, но можно вывести Property
            darkness.setProperty("быстро сгущающаяся", Place.UNKNOWN);
            Thing.EndSentence.endMessage(".");

            System.out.println("\n");

            // «Гуси едва видели друг друга, едва слышали слабый крик, которым сзывала их старая Акка.»
            // Делаем одно предложение для всех гусей
            for (Goose goose : geese) {
                goose.doSomething(Action.SEE);
                goose.doSomething(Action.HEAR);
                goose.getMessage(",");
            }
            // А старая Акка "кричит"
            akka.doSomething(Action.CRY);
            akka.getMessage(".");

            System.out.println();

            // «Нильсу казалось, что волны не могут грохотать громче, что тьма вокруг не может быть чернее.»
            // Пусть Нильс "подумал" (THINK)
            nils.doSomething(Action.THINK);
            // Волны "грохочут"
            waves.setProperty("не могут", Place.UNKNOWN);
            waves.doSomething(Action.ROAR);
            nils.getMessage(",");
            // Тьма "не может быть чернее" — проверим через наш BlacknessRecord
            BlacknessRecord darkerBlackness = BlacknessRecord.darker(blackness);
            if (darkerBlackness.level() > 2) {
                // Если вдруг чернота стала слишком сильной — бросаем непроверяемое исключение
                throw new SomethingBlackException("Слишком темно!");
            } else {
                // Иначе просто выводим
                darkness.setProperty("не может быть чернее", Place.AROUND);
                nils.getMessage(".");
            }

            System.out.println();

            // «И все-таки в какую-то минуту шум и свист внизу стал еще сильнее,
            //   а из тьмы выступило что-то еще чернее, чем небо.»
            waves.doSomething(Action.ROAR);   // шум
            waves.doSomething(Action.SWISH);  // свист
            waves.setPlace(Place.BELOW);
            waves.getMessage(","); // заканчиваем фразу запятой

            // Из темноты выступает "что-то ещё чернее"
            darkness.doSomething(Action.EMERGE);
            // Выбросим непроверяемое исключение искусственно, если рандом < 0.3
            if (Math.random() < 0.3) {
                throw new SomethingBlackException("Из тьмы выступило нечто ужасающее!");
            }

            darkness.setProperty("ещё чернее, чем небо", Place.UNKNOWN);
            darkness.getMessage(".");

        } catch (FearException e) {
            // Обрабатываем проверяемое исключение (FearException)
            System.err.println("\nОЙ, ПРОИЗОШЛ FearException!");
            System.err.println(e.getMessage());
        } catch (SomethingBlackException sbe) {
            // Обрабатываем непроверяемое исключение
            System.err.println("\nНЕЧТО ЧЁРНОЕ!");
            System.err.println(sbe.getMessage());
        }

        System.out.println("\n===== Сценарий завершён =====\n");
    }
}

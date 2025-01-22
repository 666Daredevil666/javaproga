package Objects;

import Enums.Place;
import Interfaces.IProperty;

public class Thing extends Obj implements IProperty {

    public Thing(String name) {
        super(name);
    }

    // Пример реализации IProperty
    @Override
    public void setProperty(String property, Place place) {
        // Просто выводим, что мы меняем свое свойство + место
        System.out.print(property + " " + name + " (" + place + ") ");
    }

    // Пример статического вложенного класса
    public static class EndSentence {
        public static void endMessage(String str) {
            System.out.print(str + " ");
        }
    }
}

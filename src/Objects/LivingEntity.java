package Objects;

import Enums.Action;
import Enums.Gender;
import Enums.Place;
import Exceptions.FearException;
import Exceptions.SomethingBlackException;
import Interfaces.IPlace;
import Interfaces.IProperty;

public abstract class LivingEntity extends Obj implements IPlace, IProperty {
    protected Gender gender;
    protected String message = "";
    protected String ending = "";

    public LivingEntity(String name, Gender gender) {
        super(name);
        this.gender = gender;
    }

    // Абстрактный метод - пусть наследники переопределяют логику "окончаний" для фраз
    protected abstract void getEnding(Gender gender);

    // Действие без объекта
    public void doSomething(Action action) {
        getEnding(gender);

        // Начинаем "копить" фразу, если нужно
        if (!message.isEmpty()) {
            message += " ";
        } else {
            // Если сообщение пустое, начинаем предложение с имени
            message += name + " ";
        }

        switch (action) {
            case FLY -> changeMessage("летит");
            case SEE -> changeMessage("видит");
            case HEAR -> changeMessage("слышит");
            case CRY -> changeMessage("кричит");
            case FEEL_FEAR -> changeMessage("испугался");
            case THINK -> changeMessage("подумал");
            case ROAR -> changeMessage("грохочет");
            case SWISH -> changeMessage("свистит");
            case EMERGE -> changeMessage("появился");
        }

        // Добавим окончание (a, о, и, или пустое)
        message += ending;
    }

    // Действие, направленное на другой объект (кого-то видит, слышит, и т.п.)
    public void doSomething(Action action, Obj obj) {
        doSomething(action);
        message += obj.getName() + " ";
    }

    // Приватный метод для добавления текста в текущее сообщение
    protected void changeMessage(String txt) {
        this.message += txt;
    }

    // Выводим сообщение; если знак восклицания, проверяем страх (демо использования FearException)
    public void getMessage(String punctuation) throws FearException {
        if ("!".equals(punctuation) && message.contains("испугался")) {
            // Допустим, выбросим проверяемое исключение, если сущность "испугался" и пытается воскликнуть
            throw new FearException("Слишком страшно кричать с восклицанием!");
        }
        System.out.print(this.message + punctuation + " ");
        this.message = ""; // очищаем, чтобы начинать новое предложение
    }

    // Реализация интерфейса IPlace
    @Override
    public void setPlace(Place place) {
        switch (place) {
            case SKY -> changeMessage("в небе");
            case NIGHT -> changeMessage("в ночи");
            case AROUND -> changeMessage("вокруг");
            case BELOW -> changeMessage("внизу");
            case UNKNOWN -> changeMessage("неизвестно где");
        }
    }

    // Реализация интерфейса IProperty
    @Override
    public void setProperty(String property, Place place) {
        // Допустим, просто дополняем фразу, демонстрируя свойство и место
        this.message += property + " (" + place + ") ";
    }

    // Можно переименовать персонажа (пример полиморфизма/инкапсуляции)
    public void setNewName(String newName) {
        this.name = newName;
    }
}

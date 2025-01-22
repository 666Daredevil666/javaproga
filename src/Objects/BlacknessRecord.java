package Objects;

// Пример записи (record) для хранения "уровня черноты"
public record BlacknessRecord(int level) {
    // Можно добавить методы, в т.ч. static

    public static BlacknessRecord darker(BlacknessRecord base) {
        // Допустим, просто увеличим уровень на 1
        return new BlacknessRecord(base.level + 1);
    }

    @Override
    public String toString() {
        return "Blackness(level=" + level + ")";
    }
}

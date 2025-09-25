package es.upm.miw.devops.code;

import java.util.stream.Stream;

public class Search {

    private UsersDatabase usersDatabase;

    public Search() {
        this.usersDatabase = new UsersDatabase();
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return usersDatabase.findAll()
                .filter(user -> !user.getFractions().isEmpty()
                        && user.getFractions().stream().allMatch(Fraction::isProper))
                .map(User::getId);
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return usersDatabase.findAll()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

}

package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

        public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


        public static String generateCity() {
            String[] cities = {"Самара", "Москва", "Санкт-Петербург", "Казань", "Ижевск", "Саратов", "Волгоград", "Астрахань", "Владикавказ", "Владивосток", "Екатеринбург", "Тюмень", "Новосибирск",
                    "Киров", "Псков", "Челябинск", "Ярославль", "Калиниград", "Краснодар", "Омск", "Воронеж", "Уфа", "Красноярск", "Нижний Новгород", "Алтайск", "Белгород", "Димитровград",
                    "Рязань", "Ханты_мансийск"};
            int n = (int) Math.floor(Math.random() * cities.length);
            return cities[n];
        }


        public static String generateName(String locale) {
                var faker = new Faker(new Locale(locale));
                return faker.name().lastName() + " " + faker.name().firstName();
            }


        public static String generatePhone(String locale) {
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));
        }
    }

        @Value
        public static class UserInfo {
        String city;
        String name;
        String phone;
    }


}
package com.twu.biblioteca;

import com.twu.biblioteca.exceptions.InvalidOptionException;
import com.twu.biblioteca.interfaces.Option;

import java.util.*;

public class Menu {

    private LinkedHashMap<String, Option> listOfOption;

    public Menu(LinkedHashMap<String, Option> listOfOption) {
        this.listOfOption = listOfOption;
    }

    public String showMenu() {
        StringBuilder optionListBuilder = new StringBuilder();

        for (Map.Entry<String, Option> option : listOfOption.entrySet()) {
            optionListBuilder.append(option.getKey() + " - " + option.getValue().showOptionName()).append("\n");
        }

        return optionListBuilder.toString();
    }

    public void chooseOption(String optionChoose) throws InvalidOptionException {
        try {
            listOfOption.get(optionChoose).call();
        } catch (Exception e) {
            throw new InvalidOptionException("Please select a valid option!");
        }
    }
}

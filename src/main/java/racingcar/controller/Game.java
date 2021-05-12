package racingcar.controller;

import racingcar.view.InputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {

    public static void main(String[] args) throws IOException {
        InputView.carNameInputView();
        String[] carNames = carNameInput();
        for(int i=0;i<carNames.length;i++){
            System.out.println(carNames[i]);
        }
    }

    public static String[] carNameInput() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String carNameInput = br.readLine();
        String[] carNames = getCarNames(carNameInput);
        checkCarNameInput(carNames.length);
        return carNames;
    }

    public static String[] getCarNames(String carNameInput){
        String[] carNames = carNameInput.split(",");
        return carNames;
    }

    public static void checkCarNameInput(int number) throws IOException {
        if(number > 5){
            InputView.checkInput();
            carNameInput();
        }
    }
}

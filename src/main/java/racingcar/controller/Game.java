package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.InputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Game {

    public static void main(String[] args) throws IOException {
        InputView.carNameInputView();
        String[] carNames = carNameInput();
        ArrayList<Car> cars = new ArrayList<>();
        for(int i=0;i<carNames.length;i++){
            cars.add(new Car(carNames[i]));
        }
        int tryNumber = tryNumberInput();

        StringBuilder[] racingCars = new StringBuilder[cars.size()];
        racingCarsInit(racingCars);

        for(int i=0;i< tryNumber;i++){
            for(int j=0; j<cars.size();j++){
                racingCars[j] = racingCarMove(cars.get(j).move(), racingCars[j]);
            }
        }
    }

    public static StringBuilder[] racingCarsInit(StringBuilder[] racingCars){
        for(int i=0;i<racingCars.length;i++){
            racingCars[i] = new StringBuilder("");
        }
        return racingCars;
    }

    public static StringBuilder racingCarMove(boolean isMoving, StringBuilder racingCar){
        if(isMoving){
            racingCar.append("-");
            return racingCar;
        }
        return racingCar;
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
            InputView.checkCarNameInputView();
            carNameInput();
        }
    }

    public static int tryNumberInput() throws IOException {
        InputView.tryNumberInputView();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tryNumber = Integer.parseInt(br.readLine());
        checkTryNumberInput(tryNumber);
        return tryNumber;
    }

    public static void checkTryNumberInput(int tryNumber) throws IOException {
        if(tryNumber <=0){
            InputView.checkTryNumberInputView();
            tryNumberInput();
        }
    }
}

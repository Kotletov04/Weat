package com.example.testapp.Model.CurrentWeather;

import com.example.testapp.Model.CurrentWeather.Common.Coord;
import com.example.testapp.Model.CurrentWeather.Common.Clouds;
import com.example.testapp.Model.CurrentWeather.Common.Main;
import com.example.testapp.Model.CurrentWeather.Common.Sys;
import com.example.testapp.Model.CurrentWeather.Common.Weather;
import com.example.testapp.Model.CurrentWeather.Common.Wind;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Post {
    /*coord.lon Долгота местоположения
    coord.lat Широта места*/
    @SerializedName("coord")
    @Expose

    private Coord coord;

    /*wind.speed Скорость ветра.
    Единица измерения по умолчанию: метр/сек,
    Метрическая система: метр/сек,
    Британская система: мили/час.
    wind.deg Направление ветра,
    градусы (метеорологические)
    wind.gust Порыв ветра. Единица измерения по умолчанию: метр/сек,
    Метрическая система: метр/сек,
    Британская система: мили/час.
            */
    @SerializedName("wind")
    @Expose

    private Wind wind;

    /*weather.id Идентификатор погодных условий
    weather.main Группа параметров погоды (дождь, снег, облака и т. д.)
    weather.description Погодные условия внутри группы.*/
    @SerializedName("weather")
    @Expose
    private List<Weather> weather;



    @SerializedName("base")
    @Expose
    private String base;

    /*main.temp Температура. Единица измерения по умолчанию: Кельвин, Метрическая система: Цельсий, Британская система: Фаренгейт.
    main.feels_like Температура. Этот температурный параметр отвечает за восприятие человеком погоды. Единица измерения по умолчанию: Кельвин, Метрическая система: Цельсий, Британская система: Фаренгейт.
    main.pressure Атмосферное давление на уровне моря, гПа
    main.humidity Влажность, %
    main.temp_min Минимальная температура на данный момент. Это минимальная наблюдаемая в настоящее время температура (в пределах крупных мегаполисов и городских территорий). Пожалуйста, найдите больше информации здесь. Единица измерения по умолчанию: Кельвин, Метрическая система: Цельсий, Британская система: Фаренгейт.
    main.temp_max Максимальная температура на данный момент. Это максимальная наблюдаемая в настоящее время температура (в пределах крупных мегаполисов и городских территорий). Пожалуйста, найдите больше информации здесь. Единица измерения по умолчанию: Кельвин, Метрическая система: Цельсий, Британская система: Фаренгейт.
    main.sea_level Атмосферное давление на уровне моря, гПа
    main.grnd_level Атмосферное давление на уровне земли, гПа*/

    @SerializedName("main")
    @Expose
    private Main main;

    /*Видимость, метр. Максимальное значение видимости 10 км.*/
    @SerializedName("visibility")
    @Expose
    private int visibility;

    /*clouds.all Облачность, %*/
    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    /*Время расчета данных, unix, UTC*/
    @SerializedName("dt")
    @Expose
    private int dt;

    /*sys.type Внутренний параметр
    sys.id Внутренний параметр
    sys.message Внутренний параметр
    sys.country Код страны (Великобритания, Япония и т. д.)
    sys.sunrise Время восхода солнца, unix, UTC
    sys.sunset Время заката, unix, UTC*/
    @SerializedName("sys")
    @Expose
    private Sys sys;

    /*Сдвиг в секундах от UTC*/
    @SerializedName("timezone")
    @Expose
    private int timezone;

    /*Идентификатор города.
    Обратите внимание, что встроенные функции геокодера устарели
            */
    @SerializedName("id")
    @Expose
    private int id;

    /*Название города.
    Обратите внимание, что встроенные функции геокодера устарели*/
    @SerializedName("name")
    @Expose
    private String name;

    /*Внутренний параметр*/
    @SerializedName("cod")
    @Expose
    private int cod;


    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord wind) {
        this.coord = coord;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setWeather (List<Weather> weather) {
        this.weather = weather;
    }
    public List<Weather> getWeather() {
        return weather;
    }
    public void setBase(String base) {
        this.base = base;
    }
    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public int getVisibility() {
        return visibility;
    }

    public void setVisibility(int visibility) {
        this.visibility = visibility;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
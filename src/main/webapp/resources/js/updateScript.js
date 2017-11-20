function updateScript() {

    var station = new DepartureBoard(document.getElementById('stationName'), {rowCount: 1, letterCount: 78});
    var element = document.getElementById('form:hiddenStationName');
    if (element != null) {
        station.setValue("Timetable by station: " + element.value);
    }

    var train = new DepartureBoard(document.getElementById('trainName'), {rowCount: 1, letterCount: 12});
    train.setValue("Train name");
    var route = new DepartureBoard(document.getElementById('route'), {rowCount: 1, letterCount: 35});
    route.setValue("Route");
    var depatureDateTime = new DepartureBoard(document.getElementById('depatureDateTime'), {
        rowCount: 1,
        letterCount: 18
    });
    depatureDateTime.setValue("Departure date");
    var arrivaDatelTime = new DepartureBoard(document.getElementById('arrivaDatelTime'), {
        rowCount: 1,
        letterCount: 16
    });
    arrivaDatelTime.setValue("Arrival date");

    var train0 = new DepartureBoard(document.getElementById('trainName0'), {rowCount: 1, letterCount: 12});
    var element0 = document.getElementById("form:table:0:hiddenTrainName");
    if (element0 != null) {
        train0.setValue(element0.value);
    }
    var train1 = new DepartureBoard(document.getElementById('trainName1'), {rowCount: 1, letterCount: 12});
    var element1 = document.getElementById("form:table:1:hiddenTrainName");
    if (element1 != null) {
        train1.setValue(element1.value);
    }
    var train2 = new DepartureBoard(document.getElementById('trainName2'), {rowCount: 1, letterCount: 12});
    var element2 = document.getElementById("form:table:2:hiddenTrainName");
    if (element2 != null) {
        train2.setValue(element2.value);
    }
    var train3 = new DepartureBoard(document.getElementById('trainName3'), {rowCount: 1, letterCount: 12});
    var element3 = document.getElementById("form:table:3:hiddenTrainName");
    if (element3 != null) {
        train3.setValue(element3.value);
    }
    var train4 = new DepartureBoard(document.getElementById('trainName4'), {rowCount: 1, letterCount: 12});
    var element4 = document.getElementById("form:table:4:hiddenTrainName");
    if (element4 != null) {
        train4.setValue(element4.value);
    }
    var train5 = new DepartureBoard(document.getElementById('trainName5'), {rowCount: 1, letterCount: 12});
    var element5 = document.getElementById("form:table:5:hiddenTrainName");
    if (element5 != null) {
        train5.setValue(element5.value);
    }
    var train6 = new DepartureBoard(document.getElementById('trainName6'), {rowCount: 1, letterCount: 12});
    var element6 = document.getElementById("form:table:6:hiddenTrainName");
    if (element6 != null) {
        train6.setValue(element6.value);
    }
    var train7 = new DepartureBoard(document.getElementById('trainName7'), {rowCount: 1, letterCount: 12});
    var element7 = document.getElementById("form:table:7:hiddenTrainName");
    if (element7 != null) {
        train7.setValue(element7.value);
    }
    var train8 = new DepartureBoard(document.getElementById('trainName8'), {rowCount: 1, letterCount: 12});
    var element8 = document.getElementById("form:table:8:hiddenTrainName");
    if (element8 != null) {
        train8.setValue(element8.value);
    }
    var train9 = new DepartureBoard(document.getElementById('trainName9'), {rowCount: 1, letterCount: 12});
    var element9 = document.getElementById("form:table:9:hiddenTrainName");
    if (element9 != null) {
        train9.setValue(element9.value);
    }

    var route0 = new DepartureBoard(document.getElementById('route0'), {rowCount: 1, letterCount: 35});
    var relement0 = document.getElementById("form:table:0:hiddenRoute")
    if (relement0 != null) {
        route0.setValue(relement0.value);
    }
    var route1 = new DepartureBoard(document.getElementById('route1'), {rowCount: 1, letterCount: 35});
    var relement1 = document.getElementById("form:table:1:hiddenRoute")
    if (relement1 != null) {
        route1.setValue(relement1.value);
    }
    var route2 = new DepartureBoard(document.getElementById('route2'), {rowCount: 1, letterCount: 35});
    var relement2 = document.getElementById("form:table:2:hiddenRoute")
    if (relement2 != null) {
        route2.setValue(relement2.value);
    }
    var route3 = new DepartureBoard(document.getElementById('route3'), {rowCount: 1, letterCount: 35});
    var relement3 = document.getElementById("form:table:3:hiddenRoute")
    if (relement3 != null) {
        route3.setValue(relement3.value);
    }
    var route4 = new DepartureBoard(document.getElementById('route4'), {rowCount: 1, letterCount: 35});
    var relement4 = document.getElementById("form:table:4:hiddenRoute")
    if (relement4 != null) {
        route4.setValue(relement4.value);
    }
    var route5 = new DepartureBoard(document.getElementById('route5'), {rowCount: 1, letterCount: 35});
    var relement5 = document.getElementById("form:table:5:hiddenRoute")
    if (relement5 != null) {
        route5.setValue(relement5.value);
    }
    var route6 = new DepartureBoard(document.getElementById('route6'), {rowCount: 1, letterCount: 35});
    var relement6 = document.getElementById("form:table:6:hiddenRoute")
    if (relement6 != null) {
        route6.setValue(relement6.value);
    }
    var route7 = new DepartureBoard(document.getElementById('route7'), {rowCount: 1, letterCount: 35});
    var relement7 = document.getElementById("form:table:7:hiddenRoute")
    if (relement7 != null) {
        route7.setValue(relement7.value);
    }
    var route8 = new DepartureBoard(document.getElementById('route8'), {rowCount: 1, letterCount: 35});
    var relement8 = document.getElementById("form:table:8:hiddenRoute")
    if (relement8 != null) {
        route8.setValue(relement8.value);
    }
    var route9 = new DepartureBoard(document.getElementById('route9'), {rowCount: 1, letterCount: 35});
    var relement9 = document.getElementById("form:table:9:hiddenRoute")
    if (relement9 != null) {
        route9.setValue(relement9.value);
    }

    var depatureDateTime0 = new DepartureBoard(document.getElementById('depatureDateTime0'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement0 = document.getElementById("form:table:0:hiddenDepatureDateTime")
    if (delement0 != null) {
        depatureDateTime0.setValue(delement0.value);
    }
    var depatureDateTime1 = new DepartureBoard(document.getElementById('depatureDateTime1'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement1 = document.getElementById("form:table:1:hiddenDepatureDateTime")
    if (delement1 != null) {
        depatureDateTime1.setValue(delement1.value);
    }
    var depatureDateTime2 = new DepartureBoard(document.getElementById('depatureDateTime2'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement2 = document.getElementById("form:table:2:hiddenDepatureDateTime")
    if (delement2 != null) {
        depatureDateTime2.setValue(delement2.value);
    }
    var depatureDateTime3 = new DepartureBoard(document.getElementById('depatureDateTime3'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement3 = document.getElementById("form:table:3:hiddenDepatureDateTime")
    if (delement3 != null) {
        depatureDateTime3.setValue(delement3.value);
    }
    var depatureDateTime4 = new DepartureBoard(document.getElementById('depatureDateTime4'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement4 = document.getElementById("form:table:4:hiddenDepatureDateTime")
    if (delement4 != null) {
        depatureDateTime4.setValue(delement4.value);
    }
    var depatureDateTime5 = new DepartureBoard(document.getElementById('depatureDateTime5'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement5 = document.getElementById("form:table:5:hiddenDepatureDateTime")
    if (delement5 != null) {
        depatureDateTime5.setValue(delement5.value);
    }
    var depatureDateTime6 = new DepartureBoard(document.getElementById('depatureDateTime6'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement6 = document.getElementById("form:table:6:hiddenDepatureDateTime")
    if (delement6 != null) {
        depatureDateTime6.setValue(delement6.value);
    }
    var depatureDateTime7 = new DepartureBoard(document.getElementById('depatureDateTime7'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement7 = document.getElementById("form:table:7:hiddenDepatureDateTime")
    if (delement7 != null) {
        depatureDateTime7.setValue(delement7.value);
    }
    var depatureDateTime8 = new DepartureBoard(document.getElementById('depatureDateTime8'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement8 = document.getElementById("form:table:8:hiddenDepatureDateTime")
    if (delement8 != null) {
        depatureDateTime8.setValue(delement8.value);
    }
    var depatureDateTime9 = new DepartureBoard(document.getElementById('depatureDateTime9'), {
        rowCount: 1,
        letterCount: 16
    });
    var delement9 = document.getElementById("form:table:9:hiddenDepatureDateTime")
    if (delement9 != null) {
        depatureDateTime9.setValue(delement9.value);
    }

    var arrivaDatelTime0 = new DepartureBoard(document.getElementById('arrivaDatelTime0'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement0 = document.getElementById("form:table:0:hiddenArrivaDatelTime")
    if (aelement0 != null) {
        arrivaDatelTime0.setValue(aelement0.value);
    }
    var arrivaDatelTime1 = new DepartureBoard(document.getElementById('arrivaDatelTime1'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement1 = document.getElementById("form:table:1:hiddenArrivaDatelTime")
    if (aelement1 != null) {
        arrivaDatelTime1.setValue(aelement1.value);
    }
    var arrivaDatelTime2 = new DepartureBoard(document.getElementById('arrivaDatelTime2'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement2 = document.getElementById("form:table:2:hiddenArrivaDatelTime")
    if (aelement2 != null) {
        arrivaDatelTime2.setValue(aelement2.value);
    }
    var arrivaDatelTime3 = new DepartureBoard(document.getElementById('arrivaDatelTime3'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement3 = document.getElementById("form:table:3:hiddenArrivaDatelTime")
    if (aelement3 != null) {
        arrivaDatelTime3.setValue(aelement3.value);
    }
    var arrivaDatelTime4 = new DepartureBoard(document.getElementById('arrivaDatelTime4'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement4 = document.getElementById("form:table:4:hiddenArrivaDatelTime")
    if (aelement4 != null) {
        arrivaDatelTime4.setValue(aelement4.value);
    }
    var arrivaDatelTime5 = new DepartureBoard(document.getElementById('arrivaDatelTime5'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement5 = document.getElementById("form:table:5:hiddenArrivaDatelTime")
    if (aelement5 != null) {
        arrivaDatelTime5.setValue(aelement5.value);
    }
    var arrivaDatelTime6 = new DepartureBoard(document.getElementById('arrivaDatelTime6'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement6 = document.getElementById("form:table:6:hiddenArrivaDatelTime")
    if (aelement6 != null) {
        arrivaDatelTime6.setValue(aelement6.value);
    }
    var arrivaDatelTime7 = new DepartureBoard(document.getElementById('arrivaDatelTime7'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement7 = document.getElementById("form:table:7:hiddenArrivaDatelTime")
    if (aelement7 != null) {
        arrivaDatelTime7.setValue(aelement7.value);
    }
    var arrivaDatelTime8 = new DepartureBoard(document.getElementById('arrivaDatelTime8'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement8 = document.getElementById("form:table:8:hiddenArrivaDatelTime")
    if (aelement8 != null) {
        arrivaDatelTime8.setValue(aelement8.value);
    }
    var arrivaDatelTime9 = new DepartureBoard(document.getElementById('arrivaDatelTime9'), {
        rowCount: 1,
        letterCount: 18
    });
    var aelement9 = document.getElementById("form:table:9:hiddenArrivaDatelTime")
    if (aelement9 != null) {
        arrivaDatelTime9.setValue(aelement9.value);
    }
}
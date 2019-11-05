<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url var="mainUrl" value="/"/>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

    <title>Document</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
    <jsp:include page="header.jsp"/>

    <section class="form--steps">
        <div class="form--steps-instructions">
            <div class="form--steps-container">
                <h3>Ważne!</h3>
                <p data-step="1" class="active">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="2">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="3">
                    Wybierz jedną, do
                    której trafi Twoja przesyłka.
                </p>
                <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
            </div>
        </div>

        <div class="form--steps-container">
            <div class="form--steps-counter">Krok <span>1</span>/4</div>

            <form:form action="${mainUrl}snippet" modelAttribute="donation" method="post">
                <!-- STEP 1: class .active is switching steps -->
                <div data-step="1" class="active">
                    <h3>Zaznacz co chcesz oddać:</h3>

                    <c:forEach var="category" items="${categories}">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <form:checkbox path="categories" value="${category.id}" />
                                <span class="checkbox"></span>
                                <span class="description">${category.name}</span>
                            </label>
                        </div>
                    </c:forEach>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 2 -->
                <div data-step="2">
                    <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                    <div class="form-group form-group--inline">
                        <label>
                            Liczba 60l worków:
                            <form:input path="quantity" type="number" id="quantity" />
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>



                <!-- STEP 4 -->
                <div data-step="3">
                    <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                    <c:forEach var="institution" items="${institutions}">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:radiobutton path="institution" name="institution" value="${institution.id}" id="istitution"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">${institution.name}</div>
                  <div class="subtitle">
                    Cel i misja: ${institution.description}
                  </div>
                </span>
                        </label>
                    </div>
                    </c:forEach>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 5 -->
                <div data-step="4">
                    <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Ulica <form:input path="street" type="text" id="street" /> </label>
                                <p><form:errors path="street"/> </p>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Miasto <form:input path="city" type="text" id="city"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Kod pocztowy <form:input path="zipCode" type="text" id="zipCode"/>
                                </label>
                                <p><form:errors path="zipCode"/> </p>

                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Numer telefonu <form:input path="phoneNumber" type="phone" id="phoneNumber"/>
                                </label>
                            </div>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Data <form:input path="pickUpDate" type="date" id="date"/> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Godzina <form:input path="pickUpTime" type="time" id="time" /> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Uwagi dla kuriera
                                    <form:textarea path="pickUpComment"  rows="5" id="description"/>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step" id="summary">Dalej</button>
                    </div>
                </div>


                <!-- STEP 6 -->
                <div data-step="5">
                    <h3>Podsumowanie Twojej darowizny</h3>

                    <div class="summary">
                        <div class="form-section">
                            <h4>Oddajesz:</h4>
                            <ul>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text" id="quantityView"
                                    > worki ubrań w dobrym stanie dla dzieci</span
                                    >
                                </li>

                                <li>
                                    <span class="icon icon-hand"></span>
                                    <span class="summary--text" id="institutionView"
                                    >Dla fundacji "Mam marzenie" w Warszawie</span
                                    >
                                </li>
                            </ul>
                        </div>

                        <div class="form-section form-section--columns">
                            <div class="form-section--column">
                                <h4>Adres odbioru:</h4>
                                <ul>
                                    <li id="streetView">Polna 51</li>
                                    <li id="cityView">Warszawa</li>
                                    <li id="zipCodeView">99-098</li>
                                    <li id="phoneNumberView">123 456 789</li>
                                </ul>
                            </div>

                            <div class="form-section--column">
                                <h4>Termin odbioru:</h4>
                                <ul>
                                    <li id="dateView">13/12/2018</li>
                                    <li id="timeView">15:40</li>
                                    <li id="descriptionView">Brak uwag</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="submit" class="btn">Potwierdzam</button>
                    </div>
                </div>
            </form:form>
        </div>
    </section>


</body>
    <jsp:include page="footer.jsp"/>
    <script src="<c:url value="resources/js/app.js"/>"></script>
</body>
</html>
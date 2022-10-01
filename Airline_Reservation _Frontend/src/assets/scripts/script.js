const container = document.querySelector(".container");
const seats = document.querySelectorAll(".row .seat:not(.sold)");
const count = document.getElementById("count");
const total = document.getElementById("total");
const flightSelect = document.getElementById("flight");

populateUI();

let ticketPrice = +flightSelect.value;


function setflightData(flightIndex, flightPrice) {
  localStorage.setItem("selectedflightIndex", flightIndex);
  localStorage.setItem("selectedflightPrice", flightPrice);
}


function updateSelectedCount() {
  const selectedSeats = document.querySelectorAll(".row .seat.selected");

  const seatsIndex = [...selectedSeats].map((seat) => [...seats].indexOf(seat));

  localStorage.setItem("selectedSeats", JSON.stringify(seatsIndex));

  const selectedSeatsCount = selectedSeats.length;

  count.innerText = selectedSeatsCount;
  total.innerText = selectedSeatsCount * ticketPrice;

  setflightData(flightSelect.selectedIndex, flightSelect.value);
}



function populateUI() {
  const selectedSeats = JSON.parse(localStorage.getItem("selectedSeats"));

  if (selectedSeats !== null && selectedSeats.length > 0) {
    seats.forEach((seat, index) => {
      if (selectedSeats.indexOf(index) > -1) {
        console.log(seat.classList.add("selected"));
      }
    });
  }

  const selectedflightIndex = localStorage.getItem("selectedflightIndex");

  if (selectedflightIndex !== null) {
    flightSelect.selectedIndex = selectedflightIndex;
    console.log(selectedflightIndex)
  }
}
console.log(populateUI())

flightSelect.addEventListener("change", (e) => {
  ticketPrice = +e.target.value;
  setflightData(e.target.selectedIndex, e.target.value);
  updateSelectedCount();
});


container.addEventListener("click", (e) => {
  if (
    e.target.classList.contains("seat") &&
    !e.target.classList.contains("sold")
  ) {
    e.target.classList.toggle("selected");

    updateSelectedCount();
  }
});

updateSelectedCount();

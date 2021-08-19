("use strict");

var marketCapRateIcon = document.body.querySelector(
  "div[class='col-auto market-cap-rate']"
);

var level_up_alt = "<i class='fas fa-level-up-alt text-success'></i>";
var level_down_alt = "<i class='fas fa-level-down-alt text-danger'></i>";
var marketCapRate = -1.4;
if (marketCapRate > 0) {
  marketCapRateIcon.innerHTML = level_up_alt + marketCapRate + "%";
} else {
  marketCapRateIcon.innerHTML = level_down_alt + marketCapRate + "%";
}
//console.log(marketCapRateIcon);

// Jquery
$(document).ready(function () {
  // Call the dataTables jQuery plugin
  $('#dataTable').DataTable();
});

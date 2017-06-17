var getBestTimeTomorrow = function () {
  var date = new Date();
  var mins = date.getMinutes();
  var halfHours = Math.round(mins / 30) + 1;
  if (halfHours >= 2) {
    date.setHours(date.getHours() + 1);
  }
  var rounded = (halfHours * 30) % 60;
  date.setMinutes(rounded);
  date.setDate(date.getDate() + 1);
  return date;
};
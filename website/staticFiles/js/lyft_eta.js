function geocodeAddress(geocoder, resultsMap) {
	var address = document.getElementById('address').value;
	geocoder.geocode({'address': address}, function(results, status) {
		if (status === google.maps.GeocoderStatus.OK) {
			resultsMap.setCenter(results[0].geometry.location);
			marker = new google.maps.Marker({
				map: resultsMap,
				position: results[0].geometry.location,
				draggable: true
			});
			document.getElementById('current').innerHTML = '<p>Marker: Current Lat: ' + marker.getPosition().lat().toFixed(3) + ' Current Lng: ' + marker.getPosition().lng().toFixed(3) + '</p><form action="lyftRideType" method="post" id="auth" class="auth"><input type="hidden" name="mode" value="getRideType"/><input type="hidden" name="lat" value="'+marker.getPosition().lat().toFixed(3)+'"/><input type="hidden" name="lon" value="'+marker.getPosition().lng().toFixed(3)+'"/><input type="submit" value="Confirm Location for ETA"/></form>';
		} else {
			alert('Geocode was not successful for the following reason: ' + status);
		}
	});
}
/**
 * Holds event handlers for checking if value is prime number and finding next prime number
 */

/**
 * updates result section with message and error class if needed
 * @param message result message to be set
 * @param isError error flag for adding CSS error class 
 * @returns
 */
function setResultMessage(message, isError) {
	if (isError) {
		document.getElementsByClassName('primenumber-result')[0].classList.add('primenumber-error');
	} else {
		document.getElementsByClassName('primenumber-result')[0].classList.remove('primenumber-error');
	}
	document.getElementById('primeNumberResult').innerText = message;
}

const primeNumberCheckBtn = window.document.getElementById('primeNumberCheckBtn');
primeNumberCheckBtn.addEventListener('click', function() {
	const primeNumberInput = document.getElementById('primeNumberValue');
	const primeNumberInt = parseInt(primeNumberInput.value)
	if (/^\d+$/.test(primeNumberInput.value) && !isNaN(primeNumberInt) && primeNumberInt >= 0) {
		fetch('/api/primenumber/check?query=' + primeNumberInt)
			.then(function(response) {
				if (response.status !== 200) {
					setResultMessage('Error calling service', true);
					return;
				}
				
				response.json().then(function(data) {
					if (!data.error) {
						setResultMessage('Result: ' + data.primeNumber, false);
					} else {
						setResultMessage('Missing or invalid parameter', true);
					}
				});
			})
			.catch(function(err) {
				setResultMessage(err, true);
			});
	} else {
		setResultMessage('Missing or invalid parameter', true);
	}
});

const primeNumberNextBtn = window.document.getElementById('primeNumberNextBtn');
primeNumberNextBtn.addEventListener('click', function() {
	const primeNumberInput = document.getElementById('primeNumberValue');
	const primeNumberInt = parseInt(primeNumberInput.value)
	if (/^\d+$/.test(primeNumberInput.value) && !isNaN(primeNumberInt) && primeNumberInt >= 0) {
		fetch('/api/primenumber/next?query=' + primeNumberInt)
			.then(function(response) {
				if (response.status !== 200) {
					setResultMessage('Error calling service', true);
					return;
				}
				
				response.json().then(function(data) {
					if (!data.error) {
						setResultMessage('Result: ' + data.nextPrime, false);
					} else {
						setResultMessage('Missing or invalid parameter', true);
					}
				});
			})
			.catch(function(err) {
				setResultMessage(err, true);
			});
	} else {
		setResultMessage('Missing or invalid parameter', true);
	}
});
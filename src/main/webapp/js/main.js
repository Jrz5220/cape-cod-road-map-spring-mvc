const toggleButton = document.getElementsByClassName('toggle-button')[0];
const navbarLinks = document.getElementsByClassName('navbar-links')[0];

const navbarDropdownButtons = document.getElementsByClassName('nav-dropdown-button');
const navbarDropdownMenu = document.getElementsByClassName('nav-item-dropdown-list');

const accordionItemButtons = document.getElementsByClassName('accordion-item-button');
const accordionItemBody = document.getElementsByClassName('accordion-item-body');

// display primary navbar when toggle button is clicked
toggleButton.addEventListener('click', function() {
	let ariaExpanded = toggleButton.getAttribute('aria-expanded');
	navbarLinks.classList.toggle('active');
	if(ariaExpanded !== null || ariaExpanded !== '') {
	    if(navbarLinks.classList.contains('active')) {
	      toggleButton.setAttribute('aria-expanded', 'true');
	    } else {
	      toggleButton.setAttribute('aria-expanded', 'false');
	    }
  }
});

// display/hide navbar dropdown menu when dropdown button is clicked
for(let i = 0; i < navbarDropdownButtons.length; i++) {
	let theButton = navbarDropdownButtons[i];
	let theMenu = navbarDropdownMenu[i];
	theButton.addEventListener('click', function() {
		theMenu.classList.toggle('show');
	    if(theMenu.classList.contains('show')) {
	      // scrollHeight includes padding, but not borders, margin, or horizontal scroll bar
	      theMenu.style.maxHeight = theMenu.scrollHeight + "px";
	    } else {
	      theMenu.style.maxHeight = 0;
	    }
	});
}

// close navbar dropdown menu when user clicks outside of menu
window.addEventListener('mouseup', function(event) {
	for(let i = 0; i < navbarDropdownMenu.length; i++) {
		let theDropdownButton = navbarDropdownButtons[i];
		let theDropdownMenu = navbarDropdownMenu[i];
		if(event.target !== theDropdownMenu && event.target.parentNode !== theDropdownMenu && event.target !== theDropdownButton) {
			theDropdownMenu.classList.remove('show');   // 'show' class contains no styling
			theDropdownMenu.style.maxHeight = 0;
		}
	}
});

// accordion slidedown function
for(let i = 0; i < accordionItemButtons.length; i++) {
	let theAccordionButton = accordionItemButtons[i];
	let theAccordionBody = accordionItemBody[i];
	theAccordionButton.addEventListener('click', function() {
		theAccordionButton.classList.toggle('active');
	    if(theAccordionButton.classList.contains('active')) {
	    	theAccordionBody.style.maxHeight = accordionItemBody[i].scrollHeight + "px";
	    } else {
	    	theAccordionBody.style.maxHeight = 0;
	    }
	});
}

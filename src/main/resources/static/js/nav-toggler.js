(toggler => {
    const sideNav = document.querySelector('.side-nav-couch');
    const hamburger = document.querySelector('#hamburger-icon-couch');

    hamburger.addEventListener("click", function () {
        if (this.classList.toggle('active')) {
            sideNav.style.left = '0';
        } else {
            sideNav.style.left = '-15.0rem';
        }
    });

})();







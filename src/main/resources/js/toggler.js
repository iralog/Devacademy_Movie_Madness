(toggler => {
    const sideNav = document.querySelector('.side-nav');
const hamburger = document.querySelector('#hamburger-icon');

hamburger.addEventListener("click", function () {
    if (this.classList.toggle('active')) {
        sideNav.style.left = '0';
    } else {
        sideNav.style.left = '-15.6rem';
    }
});

})();
Galleria.loadTheme('js/galleria/themes/classic/galleria.classic.min.js');
Galleria.run('.galleria');

$('#login-modal').easyModal({
    top: 200,
    overlay: 0.2
});

$('#register-modal').easyModal({
    overlay: 0.4,
    overlayClose: false
});

$('#login').click(function(e) {
    $('#login-modal').trigger('openModal');
    e.preventDefault();
});

$('#register').click(function(e) {
    $('#register-modal').trigger('openModal');
    e.preventDefault();
});

$('#rate').click(function(e) {
    $('#rate-modal').trigger('openModal');
    e.preventDefault();
});

$('#rate-modal').easyModal({
    overlay: 0.4,
    overlayClose: false
});
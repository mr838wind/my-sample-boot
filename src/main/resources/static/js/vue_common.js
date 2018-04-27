
// validations : global
Vue.use(window.vuelidate.default);

var required = window.validators.required;


// Define filters
Vue.filter("msgFilter", function(str) { return str + '--filter' });



			
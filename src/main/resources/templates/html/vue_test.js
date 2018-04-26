		
				// app
				var app = new Vue({
					el: '#app',
					data: {
						message: 'Hello Vue3  !!!',
						viewFlag: true,
						items: [{
							text: 'pear'
						}, {
							text: 'apple'
						}, {
							text: 'banana'
						}]
					},
					methods: {
						sayHello: function(item, index) {
							alert('hello: ' + index + '--' + item.text);
						}
						,onCsSayHi: function(title) {
							alert( 'hi: title=' + title );
						}
					},
					created: function(){
						
						var vm = this;
						axios.get('/rest/sample/hello')
						.then(function (response) {
							console.log(response);
							console.log('>>> data: ' + response.data);
						})
						.catch(function(error) {
							 console.log(error);
						})
						.finally(function(){
							console.log('>>> finally');
						})
						;

					}
				});
				

				
				//test
				window.app = app;

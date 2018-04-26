
			// Define a new component called button-counter
			Vue.component('button-counter', {
				props: ['title'],
				data: function () {
					return {
						count: 0
					}
				},
				template: /* multiline backslash notation not support ie */
				`
				<div>
					<h3>{{title}}</h3>
					<button v-on:click=" count++ ">
						You clicked me {{ count }} times.
					</button>
					<br/>
					<button v-on:click=" $emit('cs-say-hi', title) ">
						hi
					</button>
				</div>
				`
			});



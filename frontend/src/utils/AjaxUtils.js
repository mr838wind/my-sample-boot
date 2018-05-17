import axios from 'axios'

export default {
  
  get: function(url,config,callbackSuccess, callbackLoadStart, callbackLoadEnd) {
    this.request('get',url,config,callbackSuccess, callbackLoadStart, callbackLoadEnd);
  },
  post: function(url,config,callbackSuccess, callbackLoadStart, callbackLoadEnd) {
    this.request('post',url,config,callbackSuccess, callbackLoadStart, callbackLoadEnd);
  },

  request: function(method, url,config,callbackSuccess, callbackLoadStart, callbackLoadEnd) {

    var rqConfig = Object.assign({
      method: method,
      url : url
    }, config);

    if(callbackLoadStart) {
      //console.log('>> callbackLoadStart');
      callbackLoadStart();
    }

    axios
      .request(rqConfig)
      .then(callbackSuccess)
      .catch(e => {
        console.log(e);
      })
      .finally(() => {
        if(callbackLoadEnd) {
          //console.log('>> callbackLoadEnd');
          callbackLoadEnd();
        }
      });
  },



}

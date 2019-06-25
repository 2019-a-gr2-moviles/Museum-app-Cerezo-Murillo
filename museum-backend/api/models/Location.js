/**
 * Location.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    latitude : {
      type : 'string',
      required : true
    },
    longitude : {
      type : 'string',
      required : true
    },
    museum_location_FK : {
      model : 'museum'
    }

  },

};


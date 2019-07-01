/**
 * Museum.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    name : {
      type : 'string',
      required : true,
      minLength : 3,
      maxLength : 64
    },
    museum_location_FK : {
      model : 'location'
    },
    museum_information_FK : {
      model : 'information'
    },
    museumPicFD : {
      type : 'string'
    },
    museumPicURL : {
      type : 'string'
    }

  },

};


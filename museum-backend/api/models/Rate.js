/**
 * Rate.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    type : {
      type : 'string',
      minLength : 4,
      maxLength : 32
    },
    price : {
      type : 'number',
      min : 0
    },
    information_rate_FK : {
      model : 'information'
    }

  },

};


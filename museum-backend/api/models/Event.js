/**
 * Event.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {

    name : {
      type : 'string',
      minLength : 3,
      maxLength : 64
    },
    dateStart : {
      type : 'ref',
      columnType : 'date'
    },
    timeStart : {
      type : 'ref',
      columnType : 'time'
    },
    endDate : {
      type : 'ref',
      columnType : 'date'
    },
    endTime : {
      type : 'ref',
      columnType : 'time'
    },
    description : {
      type : 'ref',
      columnType: 'text',
      maxLength : 280
    },
    museum_event_FK : {
      model : 'museum'
    }

  },

};


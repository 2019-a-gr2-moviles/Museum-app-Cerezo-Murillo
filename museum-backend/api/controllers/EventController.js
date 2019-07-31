/**
 * EventController
 *
 * @description :: Server-side actions for handling incoming requests.
 * @help        :: See https://sailsjs.com/docs/concepts/actions
 */

module.exports = {
  
    listAll : async (req, res) => {
        const params = req.allParams()
        if (params.museumId){
            try{
                var events = []
                events = await Event
                    .find({ museum_event_FK : params.museumId})
                    .populate('museum_event_FK')
                const eventsList = []
                Object.entries(events).forEach(element => {
                    var newEvent = 
                        {
                            "id" : element[1].id,
                            "name" : element[1].name,
                            "dateStart": element[1].dateStart,
                            "timeStart" : element[1].timeStart,
                            "description" : element[1].description,
                            "endDate" : element[1].endDate,
                            "endTime" : element[1].endTime,
                            "museumId" : element[1].museum_event_FK.id,
                            "museumName" : element[1].museum_event_FK.name
                        }
                    
                    eventsList.push(newEvent)
                });
                return res.ok(eventsList)
            }catch (e){
                return res.serverError(
                    {
                        error : 400,
                        message : e
                    }
                )
            }
        }else{
            return res.badRequest(
                {
                    error : 300,
                    mensaje: 'No envía ID del museo'
                }
            )
        }
    }

};


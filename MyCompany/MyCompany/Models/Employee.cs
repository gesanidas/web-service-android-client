using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.Threading.Tasks;

namespace MyCompany.Models
{


    public class Employee
    {
        public int ID { get; set; }
        public string Name { get; set; }
      
        public string Email { get; set; }

        public string Password { get; set; }

        public string Title { get; set; }

        public int Phone { get; set; }

        [JsonProperty(NullValueHandling = NullValueHandling.Ignore)]

        public ICollection<Skill> Skills { get; set; }


    }
}

using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyCompany.Models
{
    public class Skill
    {
        public int SkillID { get; set; }
        public int EmployeeID { get; set; }
        public String Description { get; set; }

        [JsonProperty(NullValueHandling = NullValueHandling.Ignore)]

        public Employee Employee { get; set; }
    }
}

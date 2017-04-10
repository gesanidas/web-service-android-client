﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace MyCompany.Models
{
    public class EmployeeDTO
    {
        public int ID { get; set; }
        public string Name { get; set; }

        public string Email { get; set; }

        public string Password { get; set; }

        public string Title { get; set; }

        public int Phone { get; set; }

        public String SkillDescription { get; set; }

    }
}
